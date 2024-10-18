
document.addEventListener("DOMContentLoaded", function() {
    // Definiamo le traduzioni per Italiano e Inglese
    const translations = {
        it: {
            registrationTitle: "Registrati come nuovo Trainer",
            usernameLabel: "Nome Utente:",
            emailLabel: "Email:",
            fullNameLabel: "Nome Completo:",
            birthdateLabel: "Data di Nascita:",
            birthplaceLabel: "Luogo di Nascita:",
            phoneNumberLabel: "Numero di Telefono:",
            confirmPassword: "Conferma Password",
            registerButton: "Registrati",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "AREA PERSONALE",
            usernamePlaceholder: "Inserisci il tuo nome utente",
            emailPlaceholder: "Inserisci la tua email",
            fullNamePlaceholder: "Inserisci il tuo nome completo",
            birthplacePlaceholder: "Inserisci il tuo luogo di nascita",
            phoneNumberPlaceholder: "Inserisci il tuo numero di telefono",
            passwordPlaceholder: "Crea una password",
            confirmPasswordPlaceholder: "Conferma la tua password",
        },
        en: {
            registrationTitle: "Register as a new Trainer",
            usernameLabel: "Username:",
            emailLabel: "Email:",
            fullNameLabel: "Full Name:",
            birthdateLabel: "Birthdate:",
            birthplaceLabel: "Birthplace:",
            phoneNumberLabel: "Phone Number:",
            confirmPassword: "Confirm Password",
            registerButton: "Register",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "MY ACCOUNT",
            usernamePlaceholder: "Enter your username",
            emailPlaceholder: "Enter your email",
            fullNamePlaceholder: "Enter your full name",
            birthplacePlaceholder: "Enter your birthplace",
            phoneNumberPlaceholder: "Enter your phone number",
            passwordPlaceholder: "Create a password",
            confirmPasswordPlaceholder: "Confirm your password",
        }
    };

    // Selezioniamo gli elementi da tradurre
    const elementsToTranslate = {
        registrationTitle: document.querySelector('#registration-form-section h2'),
        usernameLabel: document.querySelector('label[for="new-username"]'),
        emailLabel: document.querySelector('label[for="new-email"]'),
        fullNameLabel: document.querySelector('label[for="new-full-name"]'),
        birthdateLabel: document.querySelector('label[for="new-birthdate"]'),
        birthplaceLabel: document.querySelector('label[for="new-birthplace"]'),
        phoneNumberLabel: document.querySelector('label[for="new-phone-number"]'),
        confirmPassword: document.querySelector('label[for="confirm-password"]'),
        registerButton: document.querySelector('#registration-form button[type="submit"]'),
        homeLink: document.querySelector('nav a[href="index.html"]'),
        deckbuilderLink: document.querySelector('nav a[href="deckbuilder.html"]'),
        communityLink: document.querySelector('nav a[href="community.html"]'),
        loginLink: document.querySelector('nav a[href="login.html"]'),
        usernameInput: document.querySelector('#new-username'),
        emailInput: document.querySelector('#new-email'),
        fullNameInput: document.querySelector('#new-full-name'),
        birthplaceInput: document.querySelector('#new-birthplace'),
        phoneNumberInput: document.querySelector('#new-phone-number'),
        passwordInput: document.querySelector('#new-password'),
        confirmPasswordInput: document.querySelector('#confirm-password')
    };

    // Funzione per aggiornare la lingua
    function switchLanguage(language) {
        const translation = translations[language];
        if (translation) {
            if (elementsToTranslate.registrationTitle) {
                elementsToTranslate.registrationTitle.textContent = translation.registrationTitle;
            }
            if (elementsToTranslate.usernameLabel) {
                elementsToTranslate.usernameLabel.textContent = translation.usernameLabel;
            }
            if (elementsToTranslate.emailLabel) {
                elementsToTranslate.emailLabel.textContent = translation.emailLabel;
            }
            if (elementsToTranslate.fullNameLabel) {
                elementsToTranslate.fullNameLabel.textContent = translation.fullNameLabel;
            }
            if (elementsToTranslate.birthdateLabel) {
                elementsToTranslate.birthdateLabel.textContent = translation.birthdateLabel;
            }
            if (elementsToTranslate.birthplaceLabel) {
                elementsToTranslate.birthplaceLabel.textContent = translation.birthplaceLabel;
            }
            if (elementsToTranslate.phoneNumberLabel) {
                elementsToTranslate.phoneNumberLabel.textContent = translation.phoneNumberLabel;
            }
            if (elementsToTranslate.confirmPassword) {
                elementsToTranslate.confirmPassword.textContent = translation.confirmPassword;
            }
            if (elementsToTranslate.registerButton) {
                elementsToTranslate.registerButton.textContent = translation.registerButton;
            }
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
            if (elementsToTranslate.usernameInput) {
                elementsToTranslate.usernameInput.placeholder = translation.usernamePlaceholder;
            }
            if (elementsToTranslate.emailInput) {
                elementsToTranslate.emailInput.placeholder = translation.emailPlaceholder;
            }
            if (elementsToTranslate.fullNameInput) {
                elementsToTranslate.fullNameInput.placeholder = translation.fullNamePlaceholder;
            }
            if (elementsToTranslate.birthplaceInput) {
                elementsToTranslate.birthplaceInput.placeholder = translation.birthplacePlaceholder;
            }
            if (elementsToTranslate.phoneNumberInput) {
                elementsToTranslate.phoneNumberInput.placeholder = translation.phoneNumberPlaceholder;
            }
            if (elementsToTranslate.passwordInput) {
                elementsToTranslate.passwordInput.placeholder = translation.passwordPlaceholder;
            }
            if (elementsToTranslate.confirmPasswordInput) {
                elementsToTranslate.confirmPasswordInput.placeholder = translation.confirmPasswordPlaceholder;
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

const loginForm = document.querySelector('#registration-form-section');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission behavior
            window.location.href = 'personale.html'; // Redirect to the personal area page
        });
    };