from shuffle import db

class Member(db.Model):
  id = db.Column(db.Integer, primary_key=True)
  name = db.Column(db.String(50), nullable=False)
  initials = db.Column(db.String(10), nullable=False)

  def __repr__(self):
    return "Member: {0} - {1}".format(self.name, self.initials)