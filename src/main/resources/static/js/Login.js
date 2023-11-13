document.addEventListener('DOMContentLoaded', function() {
    const contenedor = document.querySelector('.contenedor');
    const loginLink = document.querySelector('.login-link');
    const registrerLink = document.querySelector('.registrer-link');
    
  
    registrerLink.addEventListener('click', () => {
      contenedor.classList.add('active');
    });
  
    loginLink.addEventListener('click', () => {
      contenedor.classList.remove('active');
    });
  
    
  });
  