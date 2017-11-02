FROM node:latest
ADD package.json /app/package.json
RUN cd /app && npm install --production
ADD . /app/
CMD [ "node", "/app/app.js" ]