package epicarchitect.testarch.ui.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextField(
    title: String,
    value: CharSequence,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    regex: Regex? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        modifier = modifier,
        value = when {
            regex == null        -> value.toString()
            regex.matches(value) -> value.toString()
            else                 -> ""
        },
        onValueChange = if (regex == null) {
            onValueChange
        } else {
            { text: String ->
                if (regex.matches(text)) {
                    onValueChange(text)
                }
            }
        },
        label = {
            Text(title)
        },
        keyboardOptions = keyboardOptions
    )
}