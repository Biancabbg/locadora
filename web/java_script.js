/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    
    
    /* ═══════════════════════════════════════════════════
   Locadora — script.js
   ═══════════════════════════════════════════════════ */
 
/**
 * Navega para a tela indicada pelo id.
 * @param {string} id - ID do elemento .screen a exibir
 */
function go(id) {
  document.querySelectorAll('.screen').forEach(function(screen) {
    screen.classList.remove('active');
  });
 
  var target = document.getElementById(id);
  if (target) {
    target.classList.add('active');
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
 
/**
 * Valida que todos os campos obrigatórios estão preenchidos.
 * @param {HTMLFormElement} form
 * @returns {boolean}
 */
function validar(form) {
  var inputs = form.querySelectorAll('input[required], select[required]');
  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].value.trim() === '') {
      alert('Por favor, preencha todos os campos obrigatórios.');
      inputs[i].focus();
      return false;
    }
  }
  return true;
}
 
/**
 * Pede confirmação antes de excluir um registro.
 * @returns {boolean}
 */
function confirmarExclusao() {
  return confirm('Tem certeza que deseja excluir este registro? Esta ação não pode ser desfeita.');
}
 
/* ── Navegação por teclado nos cards da home ─────── */
document.addEventListener('DOMContentLoaded', function() {
  var cards = document.querySelectorAll('.home-card[tabindex]');
  cards.forEach(function(card) {
    card.addEventListener('keydown', function(e) {
      if (e.key === 'Enter' || e.key === ' ') {
        e.preventDefault();
        card.click();
      }
    });
  });
});
