const decks = [
    {
        name: 'Dragofiamma',
        types: 'Fuoco, Drago',
        author: 'FireLord99',
        cards: [
            { name: 'Charizard', type: 'Fuoco', quantity: 2, rarity: 'Rara' },
            { name: 'Blaziken', type: 'Fuoco', quantity: 1, rarity: 'Unica' },
            { name: 'Charmander', type: 'Fuoco', quantity: 4, rarity: 'Comune' },
            { name: 'Magmar', type: 'Fuoco', quantity: 4, rarity: 'Comune' },
            { name: 'Salamence', type: 'Drago', quantity: 3, rarity: 'Rara' },
            { name: 'Dratini', type: 'Drago', quantity: 4, rarity: 'Comune' },
            { name: 'Dragonite', type: 'Drago', quantity: 2, rarity: 'Rara' },
            { name: 'Torchic', type: 'Fuoco', quantity: 4, rarity: 'Comune' },
            { name: 'Combusken', type: 'Fuoco', quantity: 3, rarity: 'Non Comune' },
            { name: 'Dragonair', type: 'Drago', quantity: 4, rarity: 'Comune' },
            { name: 'Flareon', type: 'Fuoco', quantity: 3, rarity: 'Non Comune' },
            { name: 'Growlithe', type: 'Fuoco', quantity: 4, rarity: 'Comune' },
            { name: 'Arcanine', type: 'Fuoco', quantity: 2, rarity: 'Rara' },
            { name: 'Altaria', type: 'Drago', quantity: 3, rarity: 'Non Comune' },
            { name: 'Heatmor', type: 'Fuoco', quantity: 3, rarity: 'Non Comune' },
            { name: 'Reshiram', type: 'Drago', quantity: 1, rarity: 'Unica' },
            { name: 'Latios', type: 'Drago', quantity: 1, rarity: 'Unica' },
        ]
    },
    {
        name: 'AquaForce',
        types: 'Acqua, Ghiaccio',
        author: 'WaterWiz87',
        cards: [
            { name: 'Gyarados', type: 'Acqua', quantity: 1, rarity: 'Rara' },
            { name: 'Articuno', type: 'Ghiaccio', quantity: 1, rarity: 'Unica' },
            { name: 'Squirtle', type: 'Acqua', quantity: 4, rarity: 'Comune' },
            { name: 'Wartortle', type: 'Acqua', quantity: 3, rarity: 'Non Comune' },
            { name: 'Lapras', type: 'Acqua', quantity: 3, rarity: 'Rara' },
            { name: 'Seel', type: 'Ghiaccio', quantity: 4, rarity: 'Comune' },
            { name: 'Dewgong', type: 'Ghiaccio', quantity: 2, rarity: 'Non Comune' },
            { name: 'Vaporeon', type: 'Acqua', quantity: 2, rarity: 'Rara' },
            { name: 'Piplup', type: 'Acqua', quantity: 4, rarity: 'Comune' },
            { name: 'Prinplup', type: 'Acqua', quantity: 3, rarity: 'Non Comune' },
            { name: 'Empoleon', type: 'Acqua', quantity: 2, rarity: 'Rara' },
            { name: 'Totodile', type: 'Acqua', quantity: 4, rarity: 'Comune' },
            { name: 'Croconaw', type: 'Acqua', quantity: 3, rarity: 'Non Comune' },
            { name: 'Feraligatr', type: 'Acqua', quantity: 2, rarity: 'Rara' },
            { name: 'Kyogre', type: 'Acqua', quantity: 1, rarity: 'Unica' },
            { name: 'Glaceon', type: 'Ghiaccio', quantity: 3, rarity: 'Non Comune' },
            { name: 'Suicune', type: 'Acqua', quantity: 1, rarity: 'Unica' },
        ]
    },
    {
        name: 'TerraFuria',
        types: 'Terra, Roccia',
        author: 'StoneCrusher21',
        cards: [
            { name: 'Tyranitar', type: 'Roccia', quantity: 2, rarity: 'Rara' },
            { name: 'Groudon', type: 'Terra', quantity: 1, rarity: 'Unica' },
            { name: 'Geodude', type: 'Roccia', quantity: 4, rarity: 'Comune' },
            { name: 'Graveler', type: 'Roccia', quantity: 3, rarity: 'Non Comune' },
            { name: 'Golem', type: 'Roccia', quantity: 2, rarity: 'Rara' },
            { name: 'Sandshrew', type: 'Terra', quantity: 4, rarity: 'Comune' },
            { name: 'Sandslash', type: 'Terra', quantity: 3, rarity: 'Non Comune' },
            { name: 'Onix', type: 'Roccia', quantity: 4, rarity: 'Comune' },
            { name: 'Steelix', type: 'Roccia', quantity: 2, rarity: 'Rara' },
            { name: 'Diglett', type: 'Terra', quantity: 4, rarity: 'Comune' },
            { name: 'Dugtrio', type: 'Terra', quantity: 3, rarity: 'Non Comune' },
            { name: 'Cubone', type: 'Terra', quantity: 4, rarity: 'Comune' },
            { name: 'Marowak', type: 'Terra', quantity: 3, rarity: 'Non Comune' },
            { name: 'Rhydon', type: 'Roccia', quantity: 2, rarity: 'Rara' },
            { name: 'Rhyhorn', type: 'Roccia', quantity: 4, rarity: 'Comune' },
            { name: 'Regirock', type: 'Roccia', quantity: 1, rarity: 'Unica' },
        ]
    },
    {
        name: 'ElettroColpo',
        types: 'Elettro',
        author: 'ThunderStrikeX',
        cards: [
            { name: 'Pikachu', type: 'Elettro', quantity: 3, rarity: 'Comune' },
            { name: 'Zekrom', type: 'Elettro', quantity: 1, rarity: 'Rara' },
            { name: 'Magnemite', type: 'Elettro', quantity: 4, rarity: 'Comune' },
            { name: 'Magneton', type: 'Elettro', quantity: 3, rarity: 'Non Comune' },
            { name: 'Magnezone', type: 'Elettro', quantity: 2, rarity: 'Rara' },
            { name: 'Electabuzz', type: 'Elettro', quantity: 4, rarity: 'Comune' },
            { name: 'Electivire', type: 'Elettro', quantity: 2, rarity: 'Rara' },
            { name: 'Raichu', type: 'Elettro', quantity: 2, rarity: 'Rara' },
            { name: 'Voltorb', type: 'Elettro', quantity: 4, rarity: 'Comune' },
            { name: 'Electrode', type: 'Elettro', quantity: 3, rarity: 'Non Comune' },
            { name: 'Jolteon', type: 'Elettro', quantity: 3, rarity: 'Non Comune' },
            { name: 'Rotom', type: 'Elettro', quantity: 3, rarity: 'Non Comune' },
            { name: 'Zapdos', type: 'Elettro', quantity: 1, rarity: 'Unica' },
            { name: 'Ampharos', type: 'Elettro', quantity: 2, rarity: 'Rara' },
            { name: 'Luxray', type: 'Elettro', quantity: 2, rarity: 'Rara' },
            { name: 'Manectric', type: 'Elettro', quantity: 2, rarity: 'Rara' },
        ]
    },
    {
        name: 'VelenoNatura',
        types: 'Veleno, Erba',
        author: 'ToxicQueen23',
        cards: [
            { name: 'Roserade', type: 'Erba', quantity: 2, rarity: 'Rara' },
            { name: 'Gengar', type: 'Veleno', quantity: 1, rarity: 'Unica' },
            { name: 'Bulbasaur', type: 'Erba', quantity: 4, rarity: 'Comune' },
            { name: 'Ivysaur', type: 'Erba', quantity: 3, rarity: 'Non Comune' },
            { name: 'Venusaur', type: 'Erba', quantity: 2, rarity: 'Rara' },
            { name: 'Oddish', type: 'Erba', quantity: 4, rarity: 'Comune' },
            { name: 'Gloom', type: 'Erba', quantity: 3, rarity: 'Non Comune' },
            { name: 'Vileplume', type: 'Erba', quantity: 2, rarity: 'Rara' },
            { name: 'Ekans', type: 'Veleno', quantity: 4, rarity: 'Comune' },
            { name: 'Arbok', type: 'Veleno', quantity: 3, rarity: 'Non Comune' },
            { name: 'Weedle', type: 'Erba', quantity: 4, rarity: 'Comune' },
            { name: 'Kakuna', type: 'Erba', quantity: 3, rarity: 'Non Comune' },
            { name: 'Beedrill', type: 'Erba', quantity: 2, rarity: 'Rara' },
            { name: 'Zubat', type: 'Veleno', quantity: 4, rarity: 'Comune' },
            { name: 'Golbat', type: 'Veleno', quantity: 3, rarity: 'Non Comune' },
            { name: 'Crobat', type: 'Veleno', quantity: 2, rarity: 'Rara' },
            { name: 'Toxicroak', type: 'Veleno', quantity: 1, rarity: 'Unica' },
        ]
    },
];

function renderDecks() {
    const tableBody = document.querySelector('#deck-list tbody');
    tableBody.innerHTML = '';

    decks.forEach(deck => {
        const row = document.createElement('tr');
        row.classList.add('deck-row');
        row.setAttribute('data-deck', deck.name);
        row.innerHTML = `
            <td>${deck.name}</td>
            <td>${deck.types}</td>
            <td class="button-group">
                <button class="icon-btn" onclick="publishDeck('${deck.name}')"><i class="bi bi-share-fill"></i><span> Pubblica</span></button>
                <button class="icon-btn" onclick="editDeck('${deck.name}')"><i class="bi bi-pencil-square"></i><span> Modifica</span></button>
                <button class="icon-btn" onclick="deleteDeck('${deck.name}')"><i class="bi bi-trash-fill"></i><span> Cancella</span></button>
            </td>
        `;
        
        row.addEventListener('click', () => toggleDeckDetails(deck.name));
        
        tableBody.appendChild(row);
    });
}

function toggleDeckDetails(deckName) {
    const detailsRow = document.querySelector(`tr[data-deck="details-${deckName}"]`);
    if (detailsRow) {
        detailsRow.style.display = detailsRow.style.display === 'none' || detailsRow.style.display === '' ? 'table-row' : 'none';
    } else {
        const deck = decks.find(d => d.name === deckName);
        const newRow = document.createElement('tr');
        newRow.setAttribute('data-deck', `details-${deckName}`);
        newRow.classList.add('details-row');
        newRow.style.display = 'table-row'; // Show the row
        newRow.innerHTML = `
    <td colspan="3" class="card-details-inner">
        <table>
            <tbody>
                ${deck.cards.map(card => `
                    <tr>
                        <td><strong>Nome: </strong>${card.name}</td><td>  <strong>Tipo: </strong> ${card.type} </td><td> <strong>Quantità: </strong>${card.quantity} </td><td> <strong>Rarità: </strong> ${card.rarity}</td> 
                    </tr>
                `).join('')}
            </tbody>
        </table>
    </td>
`;

        
        const row = document.querySelector(`tr[data-deck="${deckName}"]`);
        row.insertAdjacentElement('afterend', newRow);
    }
}
// Initial render
renderDecks();

document.addEventListener("DOMContentLoaded", function() {
    // Define translations for Italian and English
    const translations = {
        it: {
            registrationTitle: "Dati Anagrafici",
            usernameLabel: "Nome Utente:",
            emailLabel: "Email:",
            fullNameLabel: "Nome Completo:",
            birthdateLabel: "Data di Nascita:",
            birthplaceLabel: "Luogo di Nascita:",
            phoneNumberLabel: "Numero di Telefono:",
            editButton: "Modifica",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "AREA PERSONALE",
            decksTitle: "Mazzi personali",
            deckNameHeader: "Nome Mazzo",
            deckTypesHeader: "Tipi",
            deckActionsHeader: "Azioni",
            publishButton: "Pubblica",
            editDeckButton: "Modifica",
            deleteDeckButton: "Cancella",
        },
        en: {
            registrationTitle: "User Data",
            usernameLabel: "Username:",
            emailLabel: "Email:",
            fullNameLabel: "Full Name:",
            birthdateLabel: "Birthdate:",
            birthplaceLabel: "Birthplace:",
            phoneNumberLabel: "Phone Number:",
            editButton: "Edit",
            homeLink: "HOME",
            deckbuilderLink: "DECKBUILDER",
            communityLink: "COMMUNITY",
            loginLink: "MY ACCOUNT",
            decksTitle: "Personal Decks",
            deckNameHeader: "Deck Name",
            deckTypesHeader: "Types",
            deckActionsHeader: "Actions",
            publishButton: "Publish",
            editDeckButton: "Edit",
            deleteDeckButton: "Delete",
        }
    };

    // Select the elements to be translated
    const elementsToTranslate = {
        registrationTitle: document.querySelector('#home h1'),
        usernameLabel: document.querySelector('tbody tr:nth-child(1) td:first-child strong'),
        emailLabel: document.querySelector('tbody tr:nth-child(2) td:first-child strong'),
        fullNameLabel: document.querySelector('tbody tr:nth-child(3) td:first-child strong'),
        birthdateLabel: document.querySelector('tbody tr:nth-child(4) td:first-child strong'),
        birthplaceLabel: document.querySelector('tbody tr:nth-child(5) td:first-child strong'),
        phoneNumberLabel: document.querySelector('tbody tr:nth-child(6) td:first-child strong'),
        editButtons: document.querySelectorAll('.data'),
        homeLink: document.querySelector('nav a[href="index.html"]'),
        deckbuilderLink: document.querySelector('nav a[href="deckbuilder.html"]'),
        communityLink: document.querySelector('nav a[href="community.html"]'),
        loginLink: document.querySelector('nav a[href="login.html"]'),
        decksTitle: document.querySelector('#deck-list h1'), // Decks section title
        deckNameHeader: document.querySelector('thead th:nth-child(1)'), // Table headers
        deckTypesHeader: document.querySelector('thead th:nth-child(2)'),
        deckActionsHeader: document.querySelector('thead th:nth-child(3)'),
        publishButtons: document.querySelectorAll('.bi-share-fill + span'), // Buttons in deck actions
        editDeckButtons: document.querySelectorAll('.bi-pencil-square + span'),
        deleteDeckButtons: document.querySelectorAll('.bi-trash-fill + span'),
    };

    // Function to update the language
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
            // Iterate over all edit buttons and update the text
            elementsToTranslate.editButtons.forEach(button => {
                button.querySelector('span').textContent = translation.editButton;
            });

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
            if (elementsToTranslate.decksTitle) {
                elementsToTranslate.decksTitle.textContent = translation.decksTitle;
            }
            if (elementsToTranslate.deckNameHeader) {
                elementsToTranslate.deckNameHeader.textContent = translation.deckNameHeader;
            }
            if (elementsToTranslate.deckTypesHeader) {
                elementsToTranslate.deckTypesHeader.textContent = translation.deckTypesHeader;
            }
            if (elementsToTranslate.deckActionsHeader) {
                elementsToTranslate.deckActionsHeader.textContent = translation.deckActionsHeader;
            }
            elementsToTranslate.publishButtons.forEach(button => {
                button.textContent = translation.publishButton;
            });
            elementsToTranslate.editDeckButtons.forEach(button => {
                button.textContent = translation.editDeckButton;
            });
            elementsToTranslate.deleteDeckButtons.forEach(button => {
                button.textContent = translation.deleteDeckButton;
            });

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

const loginForm = document.querySelector('#registration-form-section');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission behavior
            window.location.href = 'personale.html'; // Redirect to the personal area page
        });
    };