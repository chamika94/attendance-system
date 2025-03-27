async function login() {
    const userName = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    //use this to send credentials to the server
    const response = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ userName, password })
    });

    const result = await response.json();

    console.log(result);

}