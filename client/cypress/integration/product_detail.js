describe('My First Test', function () {
    it('Visits HomePage', function () {
        cy.visit('http://localhost:3000/')
        cy.contains('computer cases').click()
        cy.contains('Detail').click()
    })
})