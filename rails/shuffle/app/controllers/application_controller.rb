class ApplicationController < ActionController::Base
  # Prevent CSRF attacks by raising an exception.
  # For APIs, you may want to use :null_session instead.
  protect_from_forgery with: :exception
  layout 'application'

  def index

    if params[:next_member] == nil
      @next_member = peek
    else
      @next_member = params[:next_member]
    end
    if params[:random_member] == nil
      @random_member = get_random
    else
      @random_member = params[:random_member]
    end

    render :shuffle
  end

  def cycle
    @next_member = take_turn
    @random_member = get_random
    render :shuffle
  end

  def random
    @next_member = peek
    @random_member = get_random
    render :shuffle
  end

  private
    def peek
      puts "Peek called"
      # TODO
      return Member.all[0]
    end

    def take_turn
      puts "Take turn called"
      # TODO
      return Member.all[0]
    end

    def get_random
      puts "Get random called"
      # TODO
      return Member.all[0]
    end
end
