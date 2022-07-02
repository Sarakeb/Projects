module.exports = {
  up: async (queryInterface, Sequelize) => {
      await queryInterface.renameTable('availability', 'availabilities');
      await queryInterface.renameTable('competence', 'competences');
      await queryInterface.renameTable('competence_profile', 'competence_profiles');
      await queryInterface.renameTable('person', 'people');
  },

  down: async (queryInterface, Sequelize) => {
      /* await queryInterface.renameTable('availability', 'availability');
      await queryInterface.renameTable('competence', 'competence');
      await queryInterface.renameTable('competence_profile', 'competence_profile');
      await queryInterface.renameTable('person', 'person'); */
  }
};
