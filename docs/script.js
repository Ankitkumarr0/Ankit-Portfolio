const themeToggle = document.getElementById("themeToggle");
const menuToggle = document.getElementById("menuToggle");
const navLinks = document.getElementById("navLinks");
const contactForm = document.getElementById("contactForm");
const formMessage = document.getElementById("formMessage");

const savedTheme = localStorage.getItem("portfolio-theme");
if (savedTheme === "dark") document.documentElement.setAttribute("data-theme", "dark");
updateThemeButton();

function updateThemeButton() {
    if (themeToggle) {
        themeToggle.textContent = document.documentElement.getAttribute("data-theme") === "dark" ? "☀" : "☾";
    }
}

themeToggle?.addEventListener("click", () => {
    const isDark = document.documentElement.getAttribute("data-theme") === "dark";
    if (isDark) document.documentElement.removeAttribute("data-theme");
    else document.documentElement.setAttribute("data-theme", "dark");
    localStorage.setItem("portfolio-theme", isDark ? "light" : "dark");
    updateThemeButton();
});

menuToggle?.addEventListener("click", () => {
    const open = navLinks.classList.toggle("open");
    menuToggle.setAttribute("aria-expanded", String(open));
});
navLinks?.querySelectorAll("a").forEach(link => link.addEventListener("click", () => {
    navLinks.classList.remove("open");
    menuToggle?.setAttribute("aria-expanded", "false");
}));

document.getElementById("year").textContent = new Date().getFullYear();

contactForm?.addEventListener("submit", (event) => {
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const message = document.getElementById("message").value.trim();
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (name.length < 2 || !emailPattern.test(email) || message.length < 10) {
        event.preventDefault();
        formMessage.textContent = "Please enter a valid name, email and a message of at least 10 characters.";
        return;
    }
    formMessage.textContent = "";
    // Valid forms continue to the Java Servlet at action="contact".
});
