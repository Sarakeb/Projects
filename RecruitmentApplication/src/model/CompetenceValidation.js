/**
 * validate the competence form.
 * @author Moayad Alkhatib
 * @createdAt 2021-02-11
 */
class CompetenceValidation{

    /**
     * validate the form for competence and years of expereance.
     * @param {any} area of expertise.
     * @param {any} years  of experience in the area.
     * @returns an array of errors.
     */
    static validateForm(area, years){
        let err = [];
        if(area == "Choose an area of expertise"){
          err.push({message: 'Please Enter an area of expertise.'})
        }
        if(years == "Specify years of experience"){
            err.push({message: 'Please Specify years of experience.'})
          }
      
        return err;
    }

}module.exports=CompetenceValidation;