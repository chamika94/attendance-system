function logout() {
    localStorage.removeItem("token");
    window.location.href = "index.html"; 
}

document.addEventListener("DOMContentLoaded", () => {
    const token = localStorage.getItem("token");
    if (window.location.pathname.includes("index.html")) {
        if (token) {
            window.location.href = "home.html";
        }
    } 
    else if (window.location.pathname.includes("home.html")) {
        if (!token) {
            window.location.href = "index.html";
        } else {
            const welcomeMsg = document.getElementById("welcome-msg");
            if (welcomeMsg) {
                welcomeMsg.textContent = "You are logged in!";
            }
        }
    }
});
