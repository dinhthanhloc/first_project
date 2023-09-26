function submit_login() {
	password = document.getElementById("password").value;
	email = document.getElementById("email").value;

	errorEmail = document.getElementById("errorEmail");
	errorPassword = document.getElementById("errorPassword");

	check = false;

	if (email.trim().length == 0) {
		errorEmail.innerHTML = "<span class='error'>Bạn cần nhập Email</span>";
		check = true;
	} else {
		errorEmail.innerHTML = "";
	}
	if (password.trim().length == 0) {
		errorPassword.innerHTML = "<span class='error'>Bạn cần nhập Password</span>";
		check = true;
	} else {
		errorPassword.innerHTML = "";
	}
	if (check) {
		return;
	} else {
		my_form = document.getElementById("my_form");
		my_form.submit();
	}
}
function submit_signup() {
	password = document.getElementById("password").value;
	email = document.getElementById("email").value;
	username = document.getElementById("username").value;
	password_again = document.getElementById("password_again").value;

	errorUsername = document.getElementById("errorUsername");
	errorEmail = document.getElementById("errorEmail");
	errorPassword = document.getElementById("errorPassword");
	errorPasswordAgain = document.getElementById("errorPasswordAgain");

	check = false;

	if (email.trim().length == 0) {
		errorEmail.innerHTML = "<span class='error'>Bạn cần nhập Email</span>";
		check = true;
	} else {
		errorEmail.innerHTML = "";
	}
	if (password.trim().length == 0) {
		errorPassword.innerHTML = "<span class='error'>Bạn cần nhập Password</span>";
		check = true;
	} else {
		errorPassword.innerHTML = "";
	}
	if (username.trim().length == 0) {
		errorUsername.innerHTML = "<span class='error'>Bạn cần nhập Họ và tên</span>";
		check = true;
	} else {
		errorUsername.innerHTML = "";
	}
	if (password_again.trim().length == 0) {
		errorPasswordAgain.innerHTML = "<span class='error'>Bạn cần nhập Password agian</span>";
		check = true;
	} else {
		errorPasswordAgain.innerHTML = "";
	}
	if (check) {
		return;
	} else {
		my_form = document.getElementById("my_form");
		my_form.submit();
	}
}

document.addEventListener("DOMContentLoaded", function() {
	const password = document.getElementById("password");
	const show_password = document.getElementById("show_password");

	show_password.addEventListener("click", function() {
		if (password.type === "password") {
			password.type = "text";
		} else {
			password.type = "password";
		}
		if (password_again.type == "password") {
			password_again.type = "text";
		} else {
			password_again.type = "password";
		}
	});
});

