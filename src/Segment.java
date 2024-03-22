public class Segment {
    private Point p1;
    private Point p2;

    public Point getP1() {
        return p1;
    }


    public Point getP2() {
        return p2;
    }

    public Segment(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double length() {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public String toSvg(){
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black'/>",p1.x, p1.y, p2.x, p2.y);
    }
    //code below is broken

    public static Segment[] perpendicularSegments(Segment segment, Point point){
        int xd = segment.p2.x - segment.p1.x;
        int yd = segment.p2.y - segment.p1.y;
        int new_xd1 = -yd;
        int new_xy1 = xd;
        int new_xd2 = yd;
        int new_yd2 = -xd;

        int endx1 = point.x + new_xd1;
        int endy1 = point.x + new_xy1;
        int endx2 = point.x + new_xd2;
        int endy2 = point.x + new_yd2;
        Point first_end = new Point(endx1,endy1);
        Point second_end = new Point(endx2,endy2);
        Segment first = new Segment(point, first_end);
        Segment second =new Segment(point, second_end);

        return new Segment[]{first,second};
    }
}