'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.addColumn('people', 'createdAt',{
      type: Sequelize.DATE
    });
  },

  down: async (queryInterface, Sequelize) => {
     /* await queryInterface.removeColumn('people', 'createdAt'); */
  }
};
