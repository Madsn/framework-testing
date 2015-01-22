class AddLastskippedAndLastturnToMembers < ActiveRecord::Migration
  def change
    add_column :members, :last_skipped, :datetime
    add_column :members, :last_turn, :datetime
  end
end
