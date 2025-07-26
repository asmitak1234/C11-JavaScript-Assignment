
async function loadStates() {
  try {
    const res = await fetch('data.json');
    if (!res.ok) throw new Error('Failed to load data');

    const data = await res.json();
    const container = document.getElementById('states-container');

    data.states.forEach(state => {
      const card = document.createElement('div');
      card.className = 'state-card';

      card.innerHTML = `
        <h3 class="text-pink">${state.name}</h3>
        <ul type="circle">
          ${state.districts.map(d => `<li>${d}</li>`).join('')}
        </ul>
      `;
      container.appendChild(card);
    });
  } catch (err) {
    document.getElementById('states-container').textContent = 'Error loading data.';
    console.error('Data fetching error:', err);
  }
}

loadStates();
