public abstract class BaseHandler implements ParseHandler {

    ParseHandler next = null;

    @Override
    public TextComponent parse(String part){
        return null;
    }

    @Override
    public void setNext(ParseHandler handler) {
        next = handler;
    }

}
