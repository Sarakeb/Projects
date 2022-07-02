require('dotenv').config();
const bcrypt = require('bcrypt');

async function main() {
    // get the client
    const mysql = require('mysql2/promise');

    // create the connection
    const connection = await mysql.createConnection(
        {host:process.env.DB_HOST,
        user: process.env.DB_USER,
        password: process.env.DB_PASS,
        database: process.env.DB_NAME});

    // query database
    const [rows, fields] = await connection.execute(
        'SELECT id, password FROM people where password IS NOT NULL');
    //console.log(rows);
    await updatePasswords(rows, connection);

  }

  async function updatePasswords(passwords, connection){
    for(let i=0; i<passwords.length; i++){
        let salt= await bcrypt.genSalt();

        passwords[i].password = await bcrypt.hash(passwords[i].password,salt);

        //console.log(passwords[i]);

        const [results, buff] = await connection.execute(
              'UPDATE people SET password =' + JSON.stringify(passwords[i].password) +
            ' WHERE id = ' + passwords[i].id); 
    }
  }
  main();