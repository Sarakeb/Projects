'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface. changeColumn('people', 'id', {
      type: Sequelize.INTEGER,
      autoIncrement:true
     });

     await queryInterface. changeColumn('competence_profiles', 'id', {
      type: Sequelize.INTEGER,
      autoIncrement:true
     });

     await queryInterface. changeColumn('competences', 'id', {
      type: Sequelize.INTEGER,
      autoIncrement:true
     });

     await queryInterface. changeColumn('availabilities', 'id', {
      type: Sequelize.INTEGER,
      autoIncrement:true
     });
     
  },

  down: async (queryInterface, Sequelize) => {
    /**
     * Add reverting commands here.
     *
     * Example:
     * await queryInterface.dropTable('users');
     */
  }
};
