package com.permis.permisdeconduiremaroc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.permis.permisdeconduiremaroc.ui.strings.AppStrings
import com.permis.permisdeconduiremaroc.ui.viewmodel.QcmViewModel
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun PracticeQcmScreen() {
    val viewModel: QcmViewModel = remember {
        getKoin().get<QcmViewModel>()
    }

    val questions by viewModel.questions
    val currentQuestionIndex by viewModel.currentQuestionIndex
    val selectedAnswerIndex by viewModel.selectedAnswerIndex
    val showResult by viewModel.showResult
    val isLoading by viewModel.isLoading
    val score by viewModel.score
    val accuracy by viewModel.accuracy
    val currentQuestion = viewModel.currentQuestion
    val isLastQuestion = viewModel.isLastQuestion

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (questions.isEmpty()) {
            // Start screen
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = AppStrings.SCREEN_QCM,
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Testez vos connaissances avec des questions pratiques",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                if (accuracy > 0f) {
                    Text(
                        text = "Précision: ${(accuracy * 100).toInt()}%",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                }
                Button(
                    onClick = { viewModel.loadQuestions(10) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Commencer le QCM")
                }
            }
        } else if (currentQuestion != null) {
            // Quiz screen
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Progress bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Question ${currentQuestionIndex + 1}/${questions.size}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Score: $score/${questions.size}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = (currentQuestionIndex + 1).toFloat() / questions.size.toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                )
                Spacer(modifier = Modifier.height(24.dp))

                // Question card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = currentQuestion.category,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = currentQuestion.question,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(bottom = 24.dp)
                        )

                        // Answer options
                        currentQuestion.options.forEachIndexed { index, option ->
                            AnswerOption(
                                text = option,
                                isSelected = selectedAnswerIndex == index,
                                isCorrect = showResult && index == currentQuestion.correctAnswerIndex,
                                isWrong = showResult && selectedAnswerIndex == index && index != currentQuestion.correctAnswerIndex,
                                onClick = { viewModel.selectAnswer(index) },
                                enabled = !showResult
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                        }

                        // Explanation (shown after answer)
                        if (showResult && currentQuestion.explanation.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
                                        Color(0xFF4CAF50).copy(alpha = 0.1f)
                                    } else {
                                        Color(0xFFF44336).copy(alpha = 0.1f)
                                    }
                                )
                            ) {
                                Text(
                                    text = currentQuestion.explanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(12.dp),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Navigation buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                        onClick = { viewModel.previousQuestion() },
                        enabled = currentQuestionIndex > 0
                    ) {
                        Text("Précédent")
                    }

                    if (!showResult) {
                        Button(
                            onClick = { viewModel.submitAnswer() },
                            enabled = selectedAnswerIndex != null
                        ) {
                            Text("Valider")
                        }
                    } else {
                        if (isLastQuestion) {
                            Button(
                                onClick = { viewModel.resetQuiz() }
                            ) {
                                Text("Recommencer")
                            }
                        } else {
                            Button(
                                onClick = { viewModel.nextQuestion() }
                            ) {
                                Text("Suivant")
                            }
                        }
                    }
                }
            }
        } else {
            // Quiz completed
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Quiz terminé!",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Votre score: $score/${questions.size}",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                Button(
                    onClick = { viewModel.resetQuiz() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Recommencer")
                }
            }
        }
    }
}

@Composable
fun AnswerOption(
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    isWrong: Boolean,
    onClick: () -> Unit,
    enabled: Boolean
) {
    val backgroundColor = when {
        isCorrect -> Color(0xFF4CAF50).copy(alpha = 0.2f)
        isWrong -> Color(0xFFF44336).copy(alpha = 0.2f)
        isSelected -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }

    val borderColor = when {
        isCorrect -> Color(0xFF4CAF50)
        isWrong -> Color(0xFFF44336)
        isSelected -> MaterialTheme.colorScheme.primary
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(enabled = enabled) { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
