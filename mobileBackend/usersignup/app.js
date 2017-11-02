'use strict'
const http = require('http');
const processenv = require('processenv');
const port = processenv('PORT') || 3000;
const server = http.createServer((req, res) => {
  res.write('Hallo aus Node.js!');
  res.end();
});
server.listen(port, () => {
  console.log(`Server started on port ${port}.`);
});