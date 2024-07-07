package epicarchitect.testarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import epicarchitect.testarch.ui.CounterScreen
import epicarchitect.testarch.ui.theme.TestArchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestArchTheme {
                Surface {
                    CounterScreen()
                }
            }
        }
    }
}