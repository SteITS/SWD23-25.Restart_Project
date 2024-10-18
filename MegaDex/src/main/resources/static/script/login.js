document.addEventListener("DOMContentLoaded", function() {
    // Define translations for Italian and English
    const translations = {
        it: {
            welcomeTitle: "Accedi come allenatore",
            usernameLabel: "Utente:",
            passwordLabel: "Password:",
            loginButton: "Accedi",
            notRegistered: "Non sei ancora registrato?",
            registerHere: "Registrati qui",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "AREA PERSONALE",
        },
        en: {
            welcomeTitle: "Login as trainer",
            usernameLabel: "Username:",
            passwordLabel: "Password:",
            loginButton: "Login",
            notRegistered: "Not registered yet?",
            registerHere: "Register here",
            searchButton: "Search",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "MY ACCOUNT",
        }
    };

    // Select elements to translate
    const elementsToTranslate = {
        welcomeTitle: document.querySelector('#login-section h1'),
        usernameLabel: document.querySelector('label[for="username"]'),
        passwordLabel: document.querySelector('label[for="password"]'),
        loginButton: document.querySelector('#login-form button'),
        notRegistered: document.querySelector('.registrati'),
        registerLink: document.querySelector('.registrati a'),
        homeLink: document.querySelector('nav a[href="index.html"]'),
        deckbuilderLink: document.querySelector('nav a[href="deckbuilder.html"]'),
        communityLink: document.querySelector('nav a[href="community.html"]'),
        loginLink: document.querySelector('nav a[href="login.html"]'),
    };

    // Function to update the language of the page
    function switchLanguage(language) {
        const translation = translations[language];
        if (translation) { // Check if the translation exists
            // Update each translatable element
            if (elementsToTranslate.welcomeTitle) {
                elementsToTranslate.welcomeTitle.textContent = translation.welcomeTitle;
            }
            if (elementsToTranslate.usernameLabel) {
                elementsToTranslate.usernameLabel.textContent = translation.usernameLabel;
            }
            if (elementsToTranslate.passwordLabel) {
                elementsToTranslate.passwordLabel.textContent = translation.passwordLabel;
            }
            if (elementsToTranslate.loginButton) {
                elementsToTranslate.loginButton.textContent = translation.loginButton;
            }
            if (elementsToTranslate.notRegistered) {
                elementsToTranslate.notRegistered.innerHTML = `${translation.notRegistered} <br><a href="registrazione.html">${translation.registerHere}</a>`;
            }
            // Update navigation links
            if (elementsToTranslate.homeLink) {
                elementsToTranslate.homeLink.textContent = translation.homeLink;
            }
            if (elementsToTranslate.deckbuilderLink) {
                elementsToTranslate.deckbuilderLink.textContent = translation.deckbuilderLink;
            }
            if (elementsToTranslate.communityLink) {
                elementsToTranslate.communityLink.textContent = translation.communityLink;
            }
            if (elementsToTranslate.loginLink) {
                elementsToTranslate.loginLink.textContent = translation.loginLink;
            }
        }
    }

   // Aggiungi gli event listener per i pulsanti delle bandiere
   document.querySelectorAll('#language-switch button').forEach(button => {
    button.addEventListener('click', function() {
        const language = this.querySelector('img').src.includes('it.png') ? 'it' : 'en';
        switchLanguage(language);
    });
});
});

// Funzione di cambio lingua (flag switcher)
const languageSwitch = document.querySelectorAll("#language-switch button");
if (languageSwitch.length > 0) {
    languageSwitch.forEach((button) => {
        button.addEventListener("click", () => {
            const currentFlag = button.querySelector("img").getAttribute("src");
            if (currentFlag.includes("it")) {
                button.querySelector("img").setAttribute("src", "media/uk.png");
                // Aggiungi qui logica per cambiare effettivamente la lingua del sito
            } else {
                button.querySelector("img").setAttribute("src", "media/it.png");
                // Aggiungi qui logica per cambiare effettivamente la lingua del sito
            }
        });
    });
}

const loginForm = document.querySelector('#login-form');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission behavior
            window.location.href = 'personale.html'; // Redirect to the personal area page
        });
    };