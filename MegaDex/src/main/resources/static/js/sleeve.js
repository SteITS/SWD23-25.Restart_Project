document.addEventListener("DOMContentLoaded", function () {

    // Oggetto per le traduzioni
    const translations = {
        it: {
            header: {
                home: "HOME",
                deckbuilder: "DECKBUILDER",
                community: "COMMUNITY",
                personalArea: "AREA PERSONALE"
            },
            buildDeck: "Costruisci il tuo mazzo",
            search: {
                placeholder: "Cerca una carta",
                button: "Cerca"
            },
            sortBy: "Ordina per:",
            filters: "Filtri:",
            filterOptions: {
                default: "Seleziona un filtro",
                typology: "Tipologia carta",
                subtype: "Sottotipo carta",
                format: "Formato",
                type: "Tipo carta",
                edition: "Edizione",
                pokemon: "Pokémon",
                releaseDate: "Data rilascio"
            },
            sortOptions: {
                default: "Seleziona un'opzione",
                name: "Per nome",
                text: "Per testo",
                typology: "Per tipologia",
                type: "Per tipo",
                evolution: "Per evoluzione"
            },
            selectedCards: "Carte Selezionate",
            buttons: {
                save: "Salva",
                export: "Esporta",
                import: "Importa",
                importDeck: "Importa mazzo"
            },
            import: {
                placeholder: "Inserisci link",
                button: "Importa"
            }
        },
        en: {
            header: {
                home: "HOME",
                deckbuilder: "DECKBUILDER",
                community: "COMMUNITY",
                personalArea: "MY ACCOUNT"
            },
            buildDeck: "Build your deck",
            search: {
                placeholder: "Search for a card",
                button: "Search"
            },
            sortBy: "Sort by:",
            filters: "Filters:",
            filterOptions: {
                default: "Select a filter",
                typology: "Card typology",
                subtype: "Card subtype",
                format: "Format",
                type: "Card type",
                edition: "Edition",
                pokemon: "Pokémon",
                releaseDate: "Release date"
            },
            sortOptions: {
                default: "Select an option",
                name: "By name",
                text: "By text",
                typology: "By typology",
                type: "By type",
                evolution: "By evolution"
            },
            selectedCards: "Selected Cards",
            buttons: {
                save: "Save",
                export: "Export",
                import: "Import",
                importDeck: "Import deck"
            },
            import: {
                placeholder: "Insert link",
                button: "Import"
            }
        }
    };
    

    // Funzione per aggiornare la lingua della pagina
    function switchLanguage(language) {
        const translation = translations[language];

        // Cambia i testi della navbar
        document.querySelector('nav ul li:nth-child(1) a').textContent = translation.header.home;
        document.querySelector('nav ul li:nth-child(2) a').textContent = translation.header.deckbuilder;
        document.querySelector('nav ul li:nth-child(3) a').textContent = translation.header.community;
        document.querySelector('nav ul li:nth-child(4) a').textContent = translation.header.personalArea;

        // Cambia i testi delle varie sezioni
        document.querySelector('#sleeves h1').textContent = translation.buildDeck;
        document.querySelector('#search-form1 input').placeholder = translation.search.placeholder;
        document.querySelector('#search-form1 button').textContent = translation.search.button;
        document.querySelector('label[for="sort-menu"]').textContent = translation.sortBy;
        document.querySelector('label[for="filter-menu"]').textContent = translation.filters;
        document.querySelector('.selected-cards h2').textContent = translation.selectedCards;

        // Cambia i testi dei pulsanti
        const buttons = document.querySelectorAll('.button-deck');
        if (buttons.length >= 3) { // Controlla se ci sono abbastanza pulsanti
            buttons[0].textContent = translation.buttons.save;
            buttons[1].textContent = translation.buttons.export;
            buttons[2].textContent = translation.buttons.import;
        }

        document.querySelector('#search-form2 h2').textContent = translation.buttons.importDeck;
        document.querySelector('#search-form2 input').placeholder = translation.import.placeholder;
        
        // Cambia le opzioni dei filtri
        const filterMenu = document.querySelector('#filter-menu');
        if (filterMenu && filterMenu.options.length >= 8) { // Controlla se il menu a tendina ha opzioni
            filterMenu.options[0].textContent = translation.filterOptions.default;
            filterMenu.options[1].textContent = translation.filterOptions.typology;
            filterMenu.options[2].textContent = translation.filterOptions.subtype;
            filterMenu.options[3].textContent = translation.filterOptions.format;
            filterMenu.options[4].textContent = translation.filterOptions.type;
            filterMenu.options[5].textContent = translation.filterOptions.edition;
            filterMenu.options[6].textContent = translation.filterOptions.pokemon;
            filterMenu.options[7].textContent = translation.filterOptions.releaseDate;
        }

        // Cambia le opzioni di ordinamento
        const sortMenu = document.querySelector('#sort-menu');
        if (sortMenu && sortMenu.options.length >= 6) { // Controlla se il menu a tendina ha opzioni
            sortMenu.options[0].textContent = translation.sortOptions.default;
            sortMenu.options[1].textContent = translation.sortOptions.name;
            sortMenu.options[2].textContent = translation.sortOptions.text;
            sortMenu.options[3].textContent = translation.sortOptions.typology;
            sortMenu.options[4].textContent = translation.sortOptions.type;
            sortMenu.options[5].textContent = translation.sortOptions.evolution;
        }
    }

    // Aggiungi l'event listener per il cambio di lingua
    const languageSwitch = document.querySelector("#switch-lang");
    if (languageSwitch) {
        languageSwitch.addEventListener("click", function () {
            const currentFlag = document.querySelector("#flag-image").src;
            if (currentFlag.includes("it.png")) {
                document.querySelector("#flag-image").src = "media/uk.png";
                switchLanguage("en");
            } else {
                document.querySelector("#flag-image").src = "media/it.png";
                switchLanguage("it");
            }
        });
    }

});

let currentPage = 1; // Pagina corrente iniziale

// Funzione per inviare la richiesta al controller con i parametri dei filtri
async function searchCards(page = 1) {
    // Prevenire il comportamento predefinito del form
    const name = document.querySelector('input[name="card-search"]').value;
    const orderBy = document.getElementById("sort-menu").value;
    const type = document.getElementById("filter-type").value;
    const subtype = document.getElementById("filter-subtype").value;
    const supertype = document.getElementById("filter-supertype").value;
    const release = document.getElementById("filter-release").value;

    const params = new URLSearchParams({
        name: name,
        type: type,
        subtype: subtype,
        supertype: supertype,
        set: release,
        orderBy: orderBy === "Seleziona un'opzione" ? "Id" : orderBy.toLowerCase(),
        direction: "asc",
        page: page,
    });


    // Aggiungi parametri di ordinamento
    // params.orderBy = orderBy === "Seleziona un'opzione" ? "Id" : orderBy.toLowerCase();
    // params.direction = "asc";
    // params.page = page;

    try {
        const response = await fetch(`http://localhost:8080/cards?${params.toString()}`);
        if (!response.ok) {
            throw new Error("Errore durante il recupero delle carte");
        }
        const data = await response.json();
        updateCardList(data.cards);
        updatePagination(data.totalPages); // Passa il numero totale di pagine
    } catch (error) {
        console.error("Errore:", error);
    }
}

// Funzione per aggiornare la lista delle carte in base ai risultati della ricerca
function updateCardList(cards) {
    const cardListContainer = document.querySelector('.card-list');
    cardListContainer.innerHTML = '';

    if (!cards.length) {
        cardListContainer.innerHTML = '<p>Nessuna carta trovata.</p>';
        return;
    }

    cards.forEach(card => {
        const cardElement = document.createElement('div');
        cardElement.classList.add('card-item');
        cardElement.innerHTML = `
        <div class="card">
        <img src="${card.img}" alt="">      
        </div>
      `;
        cardListContainer.appendChild(cardElement);
    });
}


// Funzione per aggiornare i bottoni di navigazione
function updatePagination(totalPages) {
    const prevButton = document.getElementById('prev-page');
    const nextButton = document.getElementById('next-page');
    const currentPageDisplay = document.getElementById('current-page');

    currentPageDisplay.innerText = `Pagina ${currentPage} di ${totalPages}`;

    // Abilita/disabilita i bottoni in base alla pagina corrente
    prevButton.disabled = currentPage === 1;
    nextButton.disabled = currentPage === totalPages;
}

// Event listeners per i bottoni di navigazione
document.getElementById('prev-page').addEventListener('click', () => {
    if (currentPage > 1) {
        currentPage--;
        searchCards(currentPage);
    }
});

document.getElementById('next-page').addEventListener('click', () => {
    currentPage++;
    searchCards(currentPage);
});

// Aggiungi l'evento submit al form di ricerca
document.getElementById('search-form1').addEventListener('submit', (event) => {
    event.preventDefault();
    currentPage = 1; // Resetta la pagina a 1 quando si effettua una nuova ricerca
    searchCards(currentPage);
});

