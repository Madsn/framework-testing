class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  layout 'application'

  def index
    @nextMember = peek
    @randomMember = getRandom
    render 'shuffle'
  end

  def cycle
    @nextMember = takeTurn
    redirect_to root_path
  end

  def random
    @nextMember = getRandom
    redirect_to root_path
  end

  private
    def peek
      # TODO
      return Member.all[0]
    end

    def takeTurn
      # TODO
      return Member.all[0]
    end

    def getRandom
      # TODO
      return Member.all[0]
    end
end
