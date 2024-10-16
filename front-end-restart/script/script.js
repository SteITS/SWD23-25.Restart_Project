document.addEventListener('DOMContentLoaded', () => {
    const cardContainers = document.querySelectorAll('.card-container');
    const deckName = document.getElementById('deck-name');
    const deckCreator = document.getElementById('deck-creator');
    const deckDate = document.getElementById('deck-date');
    const deckCount = document.getElementById('deck-count');
    const deckComments = document.getElementById('deck-comments');

    cardContainers.forEach(container => {
        container.addEventListener('click', (event) => {
            const card = event.target.closest('.card');
            if (card) {
                const name = card.querySelector('p').textContent;

                // Aggiorna le informazioni nel aside
                deckName.textContent = name; // Nome del mazzo
                deckCreator.textContent = "Utente1"; // Esempio, modifica secondo necessità
                deckDate.textContent = "15 settembre 2024"; // Esempio, modifica secondo necessità
                deckCount.textContent = "60"; // Esempio, modifica secondo necessità
                deckComments.textContent = "5"; // Esempio, modifica secondo necessità
            }
        });
    });
});



document.addEventListener("DOMContentLoaded", function() {
    // Definisci le traduzioni per italiano e inglese
    const translations = {
        it: {
            welcomeTitle: "Benvenuto su MegaDex!",
            welcomeMessage: "Esplora il mondo Pokémon e scopri tutto quello che c'è da sapere sui tuoi Pokémon preferiti.",
            searchTitle: "Cerca una Carta di Pokémon",
            searchPlaceholder: "Cerca un Pokémon",
            searchButton: "Cerca",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "AREA PERSONALE",
            footerTitle: "Multinazionalona SPA",
            footerAddress: "Via Esempio 123, 00100 Roma, Italia",
            footerPhone: "+39 012 3456789",
            footerEmail: "info@multinazionalona.it"
        },
        en: {
            welcomeTitle: "Welcome to MegaDex!",
            welcomeMessage: "Explore the Pokémon world and discover everything about your favorite Pokémon.",
            searchTitle: "Search for a Pokémon Card",
            searchPlaceholder: "Search for a Pokémon",
            searchButton: "Search",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "MY ACCOUNT",
            footerTitle: "Multinazionalona SPA",
            footerAddress: "Via Example 123, 00100 Rome, Italy",
            footerPhone: "+39 012 3456789",
            footerEmail: "info@multinazionalona.it"
        }
    };

    // Seleziona gli elementi da tradurre
    const elementsToTranslate = {
        welcomeTitle: document.querySelector('#home h1'),
        welcomeMessage: document.querySelector('#home p'),
        searchTitle: document.querySelector('#search h1'),
        searchPlaceholder: document.querySelector('#search-form input[name="find"]'),
        searchButton: document.querySelector('#search-form button'),
        homeLink: document.querySelector('nav ul li:nth-child(1) a'),
        deckbuilderLink: document.querySelector('nav ul li:nth-child(2) a'),
        communityLink: document.querySelector('nav ul li:nth-child(3) a'),
        loginLink: document.querySelector('nav ul li:nth-child(4) a'),
        footerTitle: document.querySelector('.footer-info h3'),
        footerAddress: document.querySelector('.footer-info p:nth-child(2)'),
        footerPhone: document.querySelector('.footer-info p:nth-child(3)'),
        footerEmail: document.querySelector('.footer-info p:nth-child(4)')
    };

    // Funzione per aggiornare la lingua della pagina
    function switchLanguage(language) {
        const translation = translations[language];

        elementsToTranslate.welcomeTitle.textContent = translation.welcomeTitle;
        elementsToTranslate.welcomeMessage.textContent = translation.welcomeMessage;
        elementsToTranslate.searchTitle.textContent = translation.searchTitle;
        elementsToTranslate.searchPlaceholder.placeholder = translation.searchPlaceholder;
        elementsToTranslate.searchButton.textContent = translation.searchButton;
        elementsToTranslate.homeLink.textContent = translation.homeLink;
        elementsToTranslate.deckbuilderLink.textContent = translation.deckbuilderLink;
        elementsToTranslate.communityLink.textContent = translation.communityLink;
        elementsToTranslate.loginLink.textContent = translation.loginLink;
        elementsToTranslate.footerTitle.textContent = translation.footerTitle;
        elementsToTranslate.footerAddress.textContent = translation.footerAddress;
        elementsToTranslate.footerPhone.textContent = translation.footerPhone;
        elementsToTranslate.footerEmail.textContent = translation.footerEmail;
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