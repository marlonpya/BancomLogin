package com.example.bancomlogin.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bancomlogin.Destination
import com.example.bancomlogin.R


@Composable
fun LoginScreen(navController: NavController,
                viewModel: LoginViewModel) = with(viewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        Title()
        InputEmail(viewModel.email) {
            viewModel.onEmailChanged(it)
        }
        InputPassword(
            password,
            { onPasswordChanged(it) },
            isShowPassword,
            { onShowPasswordChanged(it) })
        NotRememberYourPassword {}
        RememberYourSession(
            isCheckedRememberEmail
        ) { onCheckedRememberChanged(it) }
        Spacer(modifier = Modifier.weight(1.0f))
        ButtonGetInto() {
            navController.navigate(Destination.HOME)
        }
        ButtonGetIntoGoogle() {}
    }
}

@Composable
private fun Title() {
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.wellcome),
            fontSize = 12.sp
        )
        Text(
            text = stringResource(id = R.string.start_session),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
private fun InputEmail(
    email: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = email,
        onValueChange = onValueChange,
        label = {
            Text(stringResource(id = R.string.hint_email))
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}

@Composable
private fun InputPassword(
    password: String,
    onPasswordChange: (String) -> Unit,
    isShow: Boolean = false,
    onShowChange: (Boolean) -> Unit,
) {
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = {
            Text(stringResource(id = R.string.hint_password))
        },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = run {
            if (isShow) VisualTransformation.None
            else PasswordVisualTransformation()
        },
        trailingIcon = {
            if (isShow) {
                IconButton(
                    onClick = {
                        onShowChange(false)
                    },
                ) {
                    Icon(imageVector = Icons.Filled.Visibility, contentDescription = null)
                }
            } else {
                IconButton(
                    onClick = {
                        onShowChange(true)
                    },
                ) {

                    Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = null)
                }
            }
        }
    )
}

@Composable
private fun NotRememberYourPassword(onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                onClick.invoke()
            }
        ) {
            Text(
                text = stringResource(id = R.string.not_remember_your_password),
                color = Color.Blue
            )
        }
    }

}

@Composable
private fun RememberYourSession(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                if (checked) onCheckedChange.invoke(false) else onCheckedChange.invoke(true)
            }
        )

        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = stringResource(id = R.string.remember_your_password)
        )
    }
}

@Composable
private fun ButtonGetInto(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(id = R.string.get_into))
    }
}

@Composable
private fun ButtonGetIntoGoogle(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.presence_busy),
            contentDescription = "",
            modifier = Modifier.size(14.dp)
        )
        Text(text = stringResource(id = R.string.get_into))
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        Title()
        InputEmail("marlon.arteaga.m@hotmail.com") { }
        InputPassword("123456", {}, false, {})
        NotRememberYourPassword {}
        RememberYourSession(false) {}
        Spacer(modifier = Modifier.weight(1.0f))
        ButtonGetInto() {}
        ButtonGetIntoGoogle() {}
    }
}