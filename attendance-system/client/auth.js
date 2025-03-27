function logout() {
    localStorage.removeItem("token");
    window.location.href = "index.html"; 
}

document.addEventListener("DOMContentLoaded", () => {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "index.html"; 
    } else {
        document.getElementById("welcome-msg").textContent = "You are logged in!";
    }
});