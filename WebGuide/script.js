document.addEventListener('DOMContentLoaded', () => {
    
    const navItems = document.querySelectorAll('.nav-item');
    const sections = document.querySelectorAll('.lesson-section');

    navItems.forEach(item => {
        item.addEventListener('click', () => {
            // 1. Quitar selección activa de todos los links
            navItems.forEach(nav => nav.classList.remove('active'));
            
            // 2. Activar el link presionado
            item.classList.add('active');

            // 3. Obtener el ID de la pletina objetivo ("target")
            const targetId = item.getAttribute('data-target');

            // 4. Ocultar todas las secciones simulando un SPA modernito
            sections.forEach(section => {
                section.classList.add('hidden');
                section.classList.remove('fade-in');
            });

            // 5. Mostrar la pletina correspondiente e inyectar animación
            const targetSection = document.getElementById(targetId);
            if (targetSection) {
                targetSection.classList.remove('hidden');
                
                // Forzar repintado para reiniciar animación (Truco de CSS)
                void targetSection.offsetWidth;
                
                targetSection.classList.add('fade-in');
            }
        });
    });
});
