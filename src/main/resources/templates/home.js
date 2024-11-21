
// Dark Mode/Light Mode Toggle
const modeToggle = document.getElementById("modeToggle");
const body = document.body;

modeToggle.addEventListener("click", () => {
    // Check if dark mode is active
    if (body.classList.contains("dark-mode")) {
        // Switch to light mode
        body.classList.replace("dark-mode", "light-mode");
        modeToggle.textContent = "Dark Mode"; // Update button text
    } else {
        // Switch to dark mode
        body.classList.replace("light-mode", "dark-mode");
        modeToggle.textContent = "Light Mode"; // Update button text
    }
});


// Hover Effect
document.addEventListener("mousemove", (e) => {
    const squareSize = 5; // Size of the square
    const x = Math.floor(e.pageX / squareSize) * squareSize;
    const y = Math.floor(e.pageY / squareSize) * squareSize;

    const hoverEffect = document.createElement("div");
    hoverEffect.style.position = "absolute";
    hoverEffect.style.width = `${squareSize}px`;
    hoverEffect.style.height = `${squareSize}px`;
    hoverEffect.style.top = `${y}px`;
    hoverEffect.style.left = `${x}px`;
    hoverEffect.style.background = "rgba(0, 0, 0, 0.2)";
    hoverEffect.style.pointerEvents = "none";
    hoverEffect.style.zIndex = "0";
    hoverEffect.style.transition = "opacity 0.5s";
    hoverEffect.classList.add("hover-square");

    document.body.appendChild(hoverEffect);

    setTimeout(() => {
        hoverEffect.style.opacity = "0";
        setTimeout(() => hoverEffect.remove(), 500);
    }, 300);
});
