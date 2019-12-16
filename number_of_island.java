class Solution {
    public static class Position {
      public int i;
      public int j;

      Position(int i, int j) {
        this.i = i;
        this.j = j;
      }
    }

    public int numIslands(char[][] grid) {
      LinkedList<Position> cq = new LinkedList<Position>();
      int cnt = 0;
      for (int i = 0; i < grid.length; ++i) {
        for (int j = 0; j < grid[i].length; ++j) {
          if (grid[i][j] == '1') {
            cq.push(new Position(i, j));
            ++cnt;
          }

          while (!cq.isEmpty()) {
            Position ps = cq.remove();
            grid[ps.i][ps.j] = '2';
            if (ps.i > 0 && grid[ps.i-1][ps.j] == '1') {
              cq.push(new Position(ps.i-1, ps.j));
            }
            if (ps.j > 0 && grid[ps.i][ps.j-1] == '1') {
              cq.push(new Position(ps.i, ps.j-1));
            }
            if (ps.i < grid.length-1 && grid[ps.i+1][ps.j] == '1') {
              cq.push(new Position(ps.i+1, ps.j));
            }
            if (ps.j < grid[i].length-1 && grid[ps.i][ps.j+1] == '1') {
              cq.push(new Position(ps.i, ps.j+1));
            }
          }
        }
      }

      return cnt;
    }
}
