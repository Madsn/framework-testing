class Member < ActiveRecord::Base
  validates :name, :initials, :presence => true

end
