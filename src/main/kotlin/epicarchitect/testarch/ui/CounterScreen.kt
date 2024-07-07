package epicarchitect.testarch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import epicarchitect.testarch.data.AppData
import epicarchitect.testarch.ui.component.TextField
import epicarchitect.testarch.utils.Regexps

@Composable
fun CounterScreen() {
    var clicksCount by rememberSaveable {
        mutableIntStateOf(AppData.clicksStorage.clickCount)
    }
    var clickIncreaseCount by rememberSaveable {
        mutableIntStateOf(AppData.clicksStorage.clickIncreaseValue)
    }
    var clicksToAdd by rememberSaveable {
        mutableIntStateOf(1)
    }

    Column {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "clicksCount: $clicksCount"
        )

        Row {
            TextField(
                modifier = Modifier.padding(8.dp),
                value = clickIncreaseCount.toString(),
                onValueChange = {
                   clickIncreaseCount = it.toIntOrNull() ?: 1
                },
                title = "Increase per click",
                regex = Regexps.integersOrEmpty(maxCharCount = 5),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    AppData.clicksStorage.clickIncreaseValue = clickIncreaseCount
                }
            ) {
                Text("Save")
            }
        }

        Row {
            TextField(
                modifier = Modifier.padding(8.dp),
                value = clicksToAdd.toString(),
                onValueChange = {
                    clicksToAdd = it.toIntOrNull() ?: 1
                },
                title = "Add clicks",
                regex = Regexps.integersOrEmpty(maxCharCount = 5),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    AppData.clicksStorage.clickCount += calculateClickCount(
                        clicksToAdd = clicksToAdd,
                        clickIncreaseCount = clickIncreaseCount
                    )
                    clicksCount = AppData.clicksStorage.clickCount
                }
            ) {
                Text("Add")
            }
        }
    }
}

// якобы сложная логика,
// сложную логику прост выносим в отдельную фукцию,
// если без этого выглядит стремно
private fun calculateClickCount(
    clicksToAdd: Int,
    clickIncreaseCount: Int
): Int {
    return clicksToAdd * clickIncreaseCount
}