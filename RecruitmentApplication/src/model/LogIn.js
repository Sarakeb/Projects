const Validators = require('../util/Validators');
const bcrypt = require('bcrypt');
class LogIn{
    static validateForm(userName,passWord){
        let err = [];
        if(Validators.isAUserName(userName) == false){
            err.push({message: 'Please Enter a valid username.'})
          }
          if(passWord.length < 6){
            err.push({message: 'The password must be at least 6 characters.'})
          }
          if(passWord.length > 30){
            err.push({message: 'The password can not be greater than 30 characters.'})
          }
          return err;
    }

/**
 * checks if the two passwords matches.
 * @param { any } userPass The password entered by user.
 * @param { any } dbpass The correct password in the database.
 */
static async comparePasswords(userPass, dbpass){
  return await bcrypt.compare(userPass, dbpass);
}
}
module.exports=LogIn;