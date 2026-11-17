package com.yaarai.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ChatMessage(val text: String, val fromUser: Boolean)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { YaarAiScreen() }
    }
}

@Composable
fun YaarAiScreen() {
    val messages = remember {
        mutableStateListOf(
            ChatMessage("Namaste! Main YAAR AI hoon. Aaj kis baare mein baat karein?", false)
        )
    }
    var input by remember { mutableStateOf("") }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF6F7FB)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF172554))
                        .padding(horizontal = 20.dp, vertical = 18.dp)
                ) {
                    Text("YAAR AI", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Tumhara personal AI chat space", color = Color(0xFFDDE7FF), fontSize = 13.sp)
                }

                LazyColumn(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(messages) { message ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = if (message.fromUser) Arrangement.End else Arrangement.Start
                        ) {
                            Text(
                                text = message.text,
                                modifier = Modifier
                                    .widthIn(max = 300.dp)
                                    .background(
                                        if (message.fromUser) Color(0xFFDBEAFE) else Color.White,
                                        RoundedCornerShape(18.dp)
                                    )
                                    .padding(horizontal = 14.dp, vertical = 11.dp),
                                color = Color(0xFF172033),
                                fontSize = 15.sp
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = input,
                        onValueChange = { input = it },
                        modifier = Modifier
                            .weight(1f)
                            .background(Color(0xFFF1F5F9), RoundedCornerShape(24.dp))
                            .padding(horizontal = 16.dp, vertical = 13.dp),
                        singleLine = true,
                        decorationBox = { inner ->
                            Box {
                                if (input.isEmpty()) {
                                    Text("Message likho...", color = Color.Gray, fontSize = 14.sp)
                                }
                                inner()
                            }
                        }
                    )
                    Spacer(Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            val outgoing = input.trim()
                            if (outgoing.isNotEmpty()) {
                                messages.add(ChatMessage(outgoing, true))
                                messages.add(ChatMessage(demoReply(outgoing), false))
                                input = ""
                            }
                        },
                        enabled = input.isNotBlank()
                    ) {
                        Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Send", tint = Color(0xFF1D4ED8))
                    }
                }
            }
        }
    }
}

private fun demoReply(message: String): String {
    return "Tumne kaha: \"$message\". Abhi ye demo chat hai. Real AI replies ke liye secure backend connect karna hoga."
}
