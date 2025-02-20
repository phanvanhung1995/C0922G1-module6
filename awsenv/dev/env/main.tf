resource "aws_s3_bucket" "test_bucket" {
  bucket = "${terraform.workspace}-test-bucket-123456"
  acl    = "private"

  tags = {
    Name        = "Test Bucket"
    Environment = terraform.workspace
  }
}
