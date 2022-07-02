const Sequelize = require('sequelize');

 /**
     * Defines the competenceProfile table in the database.
     * @author Moayad Alkhatib
     * @createdAt 2021-02-15
     */

class CompetenceProfile extends Sequelize.Model{
   
    /**
     * create a new instance of CompetenceProfile.
     */
    static defineCompetenceProfile(sequelize){
        CompetenceProfile.init({
            id:{
                autoIncrement:true,
                primaryKey:true,
                type: Sequelize.INTEGER
             },
            person_id:{
                type:Sequelize.INTEGER,
                allowNull: false
            },
            competence_id:{
                type:Sequelize.INTEGER,
                allowNull: false
            },
            years_of_experience:{
                type:Sequelize.FLOAT,
                allowNull: false
            },
        }, {
            uniqueKeys: {
                actions_unique: {
                    fields: ['person_id', 'competence_id']
                }  
            },
            sequelize,
            modelName: 'competence_profile',
            timestamps: false
          })
        return CompetenceProfile;
    }

}module.exports=CompetenceProfile;