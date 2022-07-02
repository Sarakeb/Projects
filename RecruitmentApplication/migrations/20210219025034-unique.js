'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface. changeColumn('people', 'email', {
      type: Sequelize.STRING,
      unique: true
     });

     await queryInterface. changeColumn('people', 'username', {
      type: Sequelize.STRING,
      unique: true
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