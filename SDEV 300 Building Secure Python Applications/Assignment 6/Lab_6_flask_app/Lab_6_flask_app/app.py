""" Doc String"""

from flask import Flask
from flask import render_template
import datetime

# Create instance of Flask app with project organization folders.
app = Flask(__name__, static_folder="Static", template_folder="Templates")


@app.route("/")
def home_page():
    """ Function for home page."""
    date_time = datetime.datetime.now()
    today = date_time.strftime("%c")
    return render_template("Home.html", time=today)


@app.route("/About.html")
def about_page():
    """ Function for About page."""
    return render_template("About.html")


@app.route("/Music.html")
def music_page():
    """ Function for Music page."""
    return render_template("Music.html")


if __name__ == "__main__":
    app.run(debug=True)
