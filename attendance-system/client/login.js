async function login() {
    const userName = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const errorMsg = document.getElementById("error-msg");

    errorMsg.textContent = "";

    // Basic validation for empty fields
    if (!userName || !password) {
        errorMsg.textContent = "Username and password are required.";
        errorMsg.style.color = "red";
        return;
    }

    try {

        //use this to send credentials to the server
        const response = await fetch("http://localhost:8080/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ userName, password })
        });



        //client-side service to communicate with login API
        if (!response.ok) {
            let errorMessage = "Invalid credentials!";
            try {
                const result = await response.json();
                errorMessage = result.message || errorMessage; 
            } catch (error) {
                console.error("Failed to parse response:", error);
            }
            errorMsg.textContent = errorMessage;
            errorMsg.style.color = "red";
            return;
        }

        // Save token for Successfully login
        const result = await response.json();
        if (result.token) {
            localStorage.setItem("token", result.token);
        } else {
            errorMsg.textContent = "Login Failed";
            errorMsg.style.color = "red";
        }


    } catch (error) {
        console.error("Network or server error:", error);
        errorMsg.textContent = "Server error. Please try again later.";
        errorMsg.style.color = "red";
    }

}