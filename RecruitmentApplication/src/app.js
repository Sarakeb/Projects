const express = require('express');
const exphbs  = require('express-handlebars');
const path = require('path');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const Auth = require('./routes/auth/Auth');
require('dotenv').config();

const app = express();

const PORT = process.env.PORT || 8080;
app.listen(PORT, () =>{
 console.log(`Listining on Port: ${PORT}`)
});

app.engine('handlebars', exphbs({defaultLayout: 'default'}));
app.set('views', path.join(__dirname, 'views/'));
app.set('view engine', 'handlebars');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

app.use(express.static(path.join(__dirname, '../public')));

app.get('*',Auth.userCheck);
app.post('*',Auth.userCheck);

//All routes
app.use('/', require('./routes/Main'));
app.use('/registration', require('./routes/Registration'));
app.use('/dashboard', Auth.authrequire, require('./routes/Dashboard'));
app.use('/availability', Auth.authrequire, require('./routes/Availability'));
app.use('/admin',Auth.adminAuthrequire, require('./routes/Admin'));
app.use('/login', require('./routes/LogIn'));
