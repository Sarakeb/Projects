const Sequelize = require('sequelize');

 /**
     * Defines the availability table in the database.
     * @author Moayad Alkhatib
     * @createdAt 2021-02-18
     */

class Availability extends Sequelize.Model{
   
    /**
     * create a new instance of Availability.
     */
    static defineAvailability(sequelize){
        Availability.init({
            id:{
                autoIncrement:true,
                primaryKey:true,
                type: Sequelize.INTEGER
             },
            person_id:{
                type:Sequelize.INTEGER,
                allowNull: false
            },
            from_date:{
                type:Sequelize.DATEONLY,
                allowNull: false
            },
            to_date:{
                type:Sequelize.DATEONLY,
                allowNull: false
            },
        }, {
            sequelize,
            modelName: 'availability',
            timestamps: false
          })
        return Availability;
    }

}module.exports=Availability;