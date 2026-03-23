/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int **transpose(int **matrix, int matrixSize, int *matrixColSize, int *returnSize, int **returnColumnSizes)
{
  *returnSize = *matrixColSize;
  *returnColumnSizes = (int *)malloc(*returnSize * sizeof(int));
  for (int i = 0; i < *returnSize; i++)
  {
    (*returnColumnSizes)[i] = matrixSize;
  }
  int **ans = (int **)malloc(*returnSize * sizeof(int *));
  for (int i = 0; i < *returnSize; i++)
  {
    *ans = (int *)malloc(matrixSize * sizeof(int));
  }
  for (int i = 0; i < *returnSize; i++)
  {
    for (int j = 0; j < matrixSize; j++)
    {
      ans[i][j] = matrix[j][i];
    }
  }
  return ans;
}