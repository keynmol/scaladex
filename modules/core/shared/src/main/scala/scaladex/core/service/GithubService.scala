package scaladex.core.service

import scala.concurrent.Future

import scaladex.core.model.GithubInfo
import scaladex.core.model.GithubResponse
import scaladex.core.model.Project
import scaladex.core.model.UserInfo

trait GithubService {
  def getProjectInfo(ref: Project.Reference): Future[GithubResponse[(Project.Reference, GithubInfo)]]
  def getUserInfo(): Future[GithubResponse[UserInfo]]
  def getUserOrganizations(login: String): Future[Seq[Project.Organization]]
  def getUserRepositories(login: String, filterPermissions: Seq[String]): Future[Seq[Project.Reference]]
  def getOrganizationRepositories(
      user: String,
      organization: Project.Organization,
      filterPermissions: Seq[String]
  ): Future[Seq[Project.Reference]]
}
