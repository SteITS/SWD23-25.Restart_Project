document.addEventListener("DOMContentLoaded", function () {

    // Oggetto per le traduzioni
    const translations = {
        it: {
            header: {
                home: "HOME",
                deckbuilder: "DECKBUILDER",
                community: "COMMUNITY",
                sleeve: "RACCOGLITORE",
                personalArea: "AREA PERSONALE"
            },
            buildDeck: "Raccoglitore",
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
                sleeve: "BINDER",
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
        document.querySelector('nav ul li:nth-child(4) a').textContent = translation.header.sleeve;
        document.querySelector('nav ul li:nth-child(5) a').textContent = translation.header.personalArea;

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
    const owned = document.getElementById("filter-sleeve").value;
    const orderBy = document.getElementById("sort-menu").value;
    const type = document.getElementById("filter-type").value;
    const subtype = document.getElementById("filter-subtype").value;
    const supertype = document.getElementById("filter-supertype").value;
    const release = document.getElementById("filter-release").value;

    const params = new URLSearchParams({
        owned: owned,
        name: name,
        type: type,
        subtype: subtype,
        supertype: supertype,
        set: release,
        orderBy: orderBy === "Seleziona un'opzione" ? "Id" : orderBy.toLowerCase(),
        direction: "asc",
        page: page,
    });

    try {
        const response = await fetch(`http://localhost:8080/api/auth/filtered-in-sleeves?${params.toString()}`);
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
        <img src="${card.img}" alt="" onclick="selectCard('${card.id}')">
        </div>
      `;
        cardListContainer.appendChild(cardElement);
    });
}

async function selectCard(cardId) {
    const param = new URLSearchParams({id: cardId})
    let card;
    try {
        const response = await fetch(`http://localhost:8080/api/deb/cardById?${param.toString()}`);
        if (!response.ok) {
            throw new Error("Errore durante il recupero della carta");
        }
        card = await response.json();
    } catch (error) {
        console.error("Errore:", error);
    }

    const cardContainer = document.querySelector('.card-details');
    cardContainer.innerHTML = '';

        const cardElement = document.createElement('div');
        const  slot = getMySleeve(card.id);
        let quantity;

        if (slot === undefined)
            quantity = 0;
        else
            quantity = slot.quantity;

        cardElement.classList.add('card-item');
        cardElement.innerHTML = `
        <div class="selected-card">
        <img src="${card.img}" alt="">
        <div class="quantity-control">
        <button class="decrement" onclick="updateQuantity('${card.id}', -1)">-</button>
        <p id="quantity-${card.id}">${quantity}</p>
        <button class="increment" onclick="updateQuantity('${card.id}', 1)">+</button>
        </div>
        </div>
       <div class="card-sheet">
    <table>
        <tbody>
            <tr>
                <td><strong>Id:</strong></td>
                <td>${card.id}</td>
            </tr>
            <tr>
                <td><strong>Set:</strong></td>
                <td>${card.set}</td>
            </tr>
            <tr>
                <td><strong>Serie:</strong></td>
                <td>${card.series}</td>
            </tr>
            <tr>
                <td><strong>Publisher:</strong></td>
                <td>${card.publisher}</td>
            </tr>
            <tr>
                <td><strong>Generazione:</strong></td>
                <td>${card.generation}</td>
            </tr>
            <tr>
                <td><strong>Data di rilascio:</strong></td>
                <td>${card.release_date}</td>
            </tr>
            <tr>
                <td><strong>Artista:</strong></td>
                <td>${card.artist}</td>
            </tr>
            <tr>
                <td><strong>Nome:</strong></td>
                <td>${card.name}</td>
            </tr>
            <tr>
                <td><strong>Numero del set:</strong></td>
                <td>${card.set_num}</td>
            </tr>
            <tr>
                <td><strong>Livello:</strong></td>
                <td>${card.level}</td>
            </tr>
            <tr>
                <td><strong>Punti vita:</strong></td>
                <td>${card.hp}</td>
            </tr>
            <tr>
                <td><strong>Evoluzione da:</strong></td>
                <td>${card.evolves_from}</td>
            </tr>
            <tr>
                <td><strong>Evoluzione a:</strong></td>
                <td>${card.evolves_to}</td>
            </tr>
            <tr>
                <td><strong>Costo di ritirata:</strong></td>
                <td>${card.retreat_cost}</td>
            </tr>
            <tr>
                <td><strong>Costo di ritirata convertito:</strong></td>
                <td>${card.converted_retreat_cost}</td>
            </tr>
            <tr>
                <td><strong>Rarità:</strong></td>
                <td>${card.rarity}</td>
            </tr>
            <tr>
                <td><strong>Testo descrittivo:</strong></td>
                <td>${card.flavor_text}</td>
            </tr>
            <tr>
                <td><strong>Numero nel Pokédex nazionale:</strong></td>
                <td>${card.national_pokedex_numbers}</td>
            </tr>
            <tr>
                <td><strong>Legalità:</strong></td>
                <td>${card.legalities}</td>
            </tr>
            <tr>
                <td><strong>Regole:</strong></td>
                <td>${card.rules}</td>
            </tr>
            <tr>
                <td><strong>Marchio di regolamento:</strong></td>
                <td>${card.regulation_mark}</td>
            </tr>
            <tr>
                <td><strong>Tratto antico:</strong></td>
                <td>${card.ancient_trait}</td>
            </tr>
            <tr>
                <td><strong>Attacchi:</strong></td>
                <td>${card.attacks}</td>
            </tr>
            <tr>
                <td><strong>Abilità:</strong></td>
                <td>${card.abilities}</td>
            </tr>
            <tr>
                <td><strong>Debolezze:</strong></td>
                <td>${card.weaknesses}</td>
            </tr>
            <tr>
                <td><strong>Resistenze:</strong></td>
                <td>${card.resistances}</td>
            </tr>
            <tr>
                <td><strong>Tipi:</strong></td>
                <td>${card.types}</td>
            </tr>
            <tr>
                <td><strong>Sottotipi:</strong></td>
                <td>${card.subtypes}</td>
            </tr>
            <tr>
                <td><strong>Supertipo:</strong></td>
                <td>${card.supertype}</td>
            </tr>
        </tbody>
    </table>
</div>
    </div> 
      `;
    cardContainer.appendChild(cardElement);
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


function getMySleeve(cardId) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/api/auth/mySleeve?cardRequest=${cardId}`, false); // false per farlo sincrono
    xhr.send();
    if (xhr.status === 200) {
        return JSON.parse(xhr.responseText);
    } else {
        console.error('Errore nella chiamata GET:', xhr.status);
        return undefined;
    }
}


async function updateQuantity(cardId, change) {
    // Ottieni il riferimento all'elemento che mostra la quantità
    const quantityElement = document.getElementById(`quantity-${cardId}`);
    let currentQuantity = parseInt(quantityElement.textContent);

    // Aggiorna la quantità
    let newQuantity = currentQuantity + change;

    // Controlla che la quantità non diventi negativa
    if (newQuantity < 0) {
        newQuantity = 0;
    }

    // Aggiorna il testo della quantità nell'interfaccia utente
    quantityElement.textContent = newQuantity;

    // Prepara i dati da inviare nella chiamata POST
    const data = {
        id: {idCard: cardId},
        quantity: newQuantity
    };

    // Effettua la chiamata POST per aggiornare la quantità nel server
    fetch('http://localhost:8080/api/auth/updateSleeve', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });

    await selectCard(cardId);
    await searchCards(currentPage);
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

