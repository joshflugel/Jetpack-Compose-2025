package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier){
    var user: String by remember { mutableStateOf("Josh") }
    var value: String by remember { mutableStateOf("Josh2") }

    Column(modifier = modifier) {
        MyTextField( user = user ) {user = it}
        MySecondTextField(value) { value = it}
        MyAdvancedTextField(value, {value = it})  // Lambda variant
        MyPasswordField(value, {value = it})

        Spacer(modifier = Modifier.height(20.dp))
        MyOutlinedTextField(value, {value = it})
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit ) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = true)  //  , readOnly = true
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {onValueChange(it)}, placeholder = {
        Box(Modifier.size(40.dp).background(Color.Red)) // Red when text is empty
    },
        label = { Text("Type your email") }
        )
}

@Composable
fun MyAdvancedTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {
        // if(it.contains("a")) {      // redundant, but explanatory code is commented
            onValueChange(it.replace("a",""))
        // } else {
        //    onValueChange(it)
        //}
    })
}

@Composable
fun MyPasswordField(value: String, onValueChange: (String) -> Unit) { // Eye icon to show or cloak *** password
    var passwordHidden: Boolean by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Type Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if(passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(text = if(passwordHidden) "Mostrar" else "Ocultar",
            modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
        // trailingIcon -> Text -> modifier.clickable -> pwdHidden = !pwdHidden
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(value, onValueChange = { onValueChange(it) })
    // BasicTextField(value, onValueChange = { onValueChange(it) }) prent of all
}
