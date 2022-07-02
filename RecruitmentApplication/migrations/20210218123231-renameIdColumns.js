'use strict';

module.exports = {
  up: async (queryInterface, Sequelize) => {
    await queryInterface.renameColumn('availabilities', 'availability_id', 'id');
    await queryInterface.renameColumn('competence_profiles', 'competence_profile_id', 'id');
    await queryInterface.renameColumn('competences', 'competence_id', 'id');
    await queryInterface.renameColumn('people', 'person_id', 'id');
  },

  down: async (queryInterface, Sequelize) => {
    /* await queryInterface.renameColumn('availabilities', 'availability_id', 'availability_id');
    await queryInterface.renameColumn('competence_profiles', 'competence_profile_id', 'competence_profile_id');
    await queryInterface.renameColumn('competences', 'competence_id', 'competence_id');
    await queryInterface.renameColumn('people', 'person_id', 'person_id'); */
  }
};
