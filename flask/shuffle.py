import os
from flask import Flask, render_template, request, flash, redirect, url_for
from flask_sqlalchemy import SQLAlchemy

basedir = os.path.abspath(os.path.dirname(__file__))

app = Flask(__name__)
app.config['SECRET_KEY'] = '34odsifjn324p¤%!98e4pej32p9hnf'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + os.path.join(basedir, 'shuffle.db')
db = SQLAlchemy(app)

@app.route('/index')
def index():
  return 'Hello world!'


if __name__ == "__main__":
  app.run()