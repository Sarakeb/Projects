const Sequelize = require('sequelize');

 /**
     * Defines the competence table in the database.
     * @author Moayad Alkhatib
     * @createdAt 2021-02-11
     */

class Competence extends Sequelize.Model{
   
    /**
     * create a new instance of competence.
     */
    static defineCompetence(sequelize){
        Competence.init({
            id:{
                autoIncrement:true,
                primaryKey:true,
                type: Sequelize.INTEGER
             },
            name:{
                type:Sequelize.STRING,
                allowNull: false
            }
        }, {
            sequelize,
            modelName: 'competence',
            timestamps: false
          })
        return Competence;
    }

}module.exports=Competence;