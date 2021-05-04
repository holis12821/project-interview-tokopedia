package com.tokopedia.minimumpathsum

object Solution {
    fun minimumPathSum(matrix: Array<IntArray>): Int {
        // TODO, find a path from top left to bottom right which minimizes the sum of all numbers along its path, and return the sum
        // below is stub
       val rows = matrix.size
       val cols = matrix[0].size
       val arrayMatrix = arrayOf(
               intArrayOf(rows),
               intArrayOf(cols)
       )
       for (i in matrix.indices) {
           for (j in arrayMatrix.indices) {
               if (i == rows-1 && cols != cols-1 ) {
                   arrayMatrix[i][j] = matrix[i][j] + arrayMatrix[i][j+1]
               } else if (j == cols-1 && i != rows-1 ) {
                   arrayMatrix[i][j] = matrix[i][j] + arrayMatrix[i+1][j]
               } else if (i != rows-1 && j != cols-1) {
                   arrayMatrix[i][j] = matrix[i][j]  + arrayMatrix[i + 1][j].coerceAtLeast(arrayMatrix[i][j + 1])
               } else {
                   arrayMatrix[i][j] = matrix[i][j]
               }
           }
       }
       return arrayMatrix[0][0]
    }

}
